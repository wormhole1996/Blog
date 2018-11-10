package xyz.stackoverflow.blog.web.controller.admin.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.stackoverflow.blog.pojo.entity.Article;
import xyz.stackoverflow.blog.pojo.entity.Category;
import xyz.stackoverflow.blog.pojo.vo.ArticleVO;
import xyz.stackoverflow.blog.service.ArticleService;
import xyz.stackoverflow.blog.service.CategoryService;
import xyz.stackoverflow.blog.util.web.BaseController;
import xyz.stackoverflow.blog.validator.ArticleValidator;

import java.util.List;

/**
 * 后台管理系统写文章控制器
 *
 * @author 凉衫薄
 */
@Controller
@RequestMapping("/admin/article")
public class ArticlePageController extends BaseController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleValidator articleValidator;

    /**
     * 通过文章url获取code
     *
     * @param url
     * @return
     */
    private String urlToCode(String url) {
        String[] list = url.split("/");
        return list[list.length - 1];
    }

    /**
     * 跳转到文章编辑页面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public ModelAndView article(@RequestParam(value = "id", required = false) String id) {
        ModelAndView mv = new ModelAndView();

        List<Category> list = categoryService.getAllCategory();

        if (id != null) {
            Article article = articleService.getArticleById(id);
            ArticleVO articleVO = new ArticleVO();
            articleVO.setTitle(article.getTitle());
            articleVO.setArticleCode(urlToCode(article.getUrl()));
            articleVO.setArticleMd(article.getArticleMd());
            mv.addObject("selected", article.getCategoryId());
            mv.addObject("article", articleVO);
        } else {
            mv.addObject("selected", categoryService.getCategoryByCode("uncategory").getId());
        }

        mv.addObject("categoryList", list);
        mv.setViewName("/admin/article/article");

        return mv;
    }


}
