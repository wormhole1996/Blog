package xyz.stackoverflow.blog.web.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.stackoverflow.blog.pojo.entity.User;
import xyz.stackoverflow.blog.pojo.vo.ResponseVO;
import xyz.stackoverflow.blog.pojo.vo.UserVO;
import xyz.stackoverflow.blog.service.UserService;
import xyz.stackoverflow.blog.validator.UserValidator;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册页面控制器
 *
 * @author 凉衫薄
 */
@Controller
public class RegisterPageController {

    private final Integer SUCCESS = 0;
    private final Integer FAILURE = 1;

    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator validator;

    /**
     * 注册信息提交 /register
     * 方法 POST
     *
     * @param userVO
     * @param session
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO register(@RequestBody UserVO userVO, HttpSession session) {

        ResponseVO response = new ResponseVO();
        Map<String,String> map = new HashMap<>();

        User admin = userService.getAdmin();
        if (admin == null) {
            String vcode = (String) session.getAttribute("vcode");
            if (!vcode.equalsIgnoreCase(userVO.getVcode())) {
                map.put("vcode", "验证码错误");
                response.setStatus(FAILURE);
                response.setMessage("验证码错误");
                response.setData(map);
                return response;
            }

            if (userService.isExist(userVO.getEmail())) {
                map.put("email", "邮箱已经存在");
                response.setStatus(FAILURE);
                response.setMessage("邮箱已经存在");
                response.setData(map);
                return response;
            }

            map = validator.validate(userVO);
            if (map.size() != 0) {
                response.setStatus(FAILURE);
                response.setMessage("注册信息格式错误");
                response.setData(map);
            } else {
                User user = userVO.toUser();
                user.setDeleteAble(0);
                User newUser = userService.insertUser(user);
                userService.grantRole("admin", newUser.getId());
                response.setStatus(SUCCESS);
                response.setMessage("注册成功");
            }
        } else {
            response.setStatus(FAILURE);
            response.setMessage("不能再进行注册");
        }
        return response;

    }

    /**
     * 注册页面跳转 /register
     * 方法 GET
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/register";
    }
}