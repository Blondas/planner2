package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.ViewEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("viewDao")
public class ViewDao extends GenericQuery implements DaoInterface<ViewEntity, Long>{

    @Override
    public ViewEntity getById(Long id) {
        beginTransaction();

        Criteria criteria = getSession().createCriteria(ViewEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        ViewEntity ViewEntity = (ViewEntity) criteria.uniqueResult();

        endTransaction();

        return ViewEntity;
    }

    public List<ViewEntity> getList(){
        beginTransaction();
        List<ViewEntity> list = session.createCriteria(ViewEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(List<ViewEntity> viewEntities){
        beginTransaction();
        for ( int i=0; i< viewEntities.size(); i++ ) {
            getSession().save(viewEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void add(ViewEntity viewEntity) {
        beginTransaction();
        getSession().save(viewEntity);
        endTransaction();
    }

    public void update(ViewEntity viewEntity) {
        beginTransaction();
        getSession().update(viewEntity);
        endTransaction();
    }

    public void delete(ViewEntity viewEntity) {
        beginTransaction();
        getSession().delete(viewEntity);
        endTransaction();
    }

    public ViewEntity saveOrUpdate(ViewEntity viewEntity){
        beginTransaction();
        getSession().saveOrUpdate(viewEntity);
        endTransaction();

        return viewEntity;
    }

}