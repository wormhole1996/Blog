package xyz.stackoverflow.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.stackoverflow.blog.dao.VisitDao;
import xyz.stackoverflow.blog.pojo.entity.Visit;
import xyz.stackoverflow.blog.util.db.Page;
import xyz.stackoverflow.blog.util.db.UUIDGenerator;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 访问量服务实现类
 *
 * @author 凉衫薄
 */
@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDao dao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Visit> selectByPage(Page page) {
        return dao.selectByPage(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Visit> selectByCondition(Map<String, Object> searchMap) {
        return dao.selectByCondition(searchMap);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Visit selectById(String id) {
        return dao.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Visit insert(Visit visit) {
        visit.setId(UUIDGenerator.getId());
        dao.insert(visit);
        return dao.selectById(visit.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchInsert(List<Visit> list) {
        for (Visit visit : list) {
            visit.setId(UUIDGenerator.getId());
        }
        return dao.batchInsert(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Visit deleteById(String id) {
        return dao.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchDeleteById(List<String> list) {
        return dao.batchDeleteById(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Visit update(Visit visit) {
        dao.update(visit);
        return dao.selectById(visit.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int batchUpdate(List<Visit> list) {
        return dao.batchUpdate(list);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Visit> selectByDate(Date startDate, Date endDate) {
        return dao.selectByDate(startDate, endDate);
    }

}
