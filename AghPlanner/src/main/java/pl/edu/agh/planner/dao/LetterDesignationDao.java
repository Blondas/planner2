package pl.edu.agh.planner.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import pl.edu.agh.planner.domain.LetterDesignationEntity;
import pl.edu.agh.planner.utils.GenericQuery;

import java.util.List;

@Component("letterDesignationDao")
public class LetterDesignationDao extends GenericQuery implements DaoInterface<LetterDesignationEntity, Long>{

    @Override
    public LetterDesignationEntity getById (Long id) {
        beginTransaction();

        Criteria criteria = session.createCriteria(LetterDesignationEntity.class);
        criteria.add( Restrictions.naturalId().set("id", id)).setCacheable(true);
        LetterDesignationEntity letterDesignation = (LetterDesignationEntity) criteria.uniqueResult();

        endTransaction();

        return letterDesignation;
    }

    @Override
    public List<LetterDesignationEntity> getList() {
        beginTransaction();
        List<LetterDesignationEntity> list = session.createCriteria(LetterDesignationEntity.class).list();
        endTransaction();

        return list;
    }

    public void add(LetterDesignationEntity letterDesignation) {
        beginTransaction();
        getSession().save(letterDesignation);
        endTransaction();
    }

    @Override
    public void add(List<LetterDesignationEntity> letterDesignationEntities) {
        beginTransaction();
        for ( int i=0; i<letterDesignationEntities.size(); i++ ) {
            getSession().save(letterDesignationEntities.get(i));
            if ( i % FULL_BATCH_SIZE == 0 ) {
                getSession().flush();
                getSession().clear();
            }
        }
        endTransaction();
    }

    public void update(LetterDesignationEntity letterDesignation) {
        beginTransaction();
        getSession().update(letterDesignation);
        endTransaction();
    }

    public void delete(LetterDesignationEntity letterDesignation) {
        beginTransaction();
        getSession().delete(letterDesignation);
        endTransaction();
    }

    @Override
    public LetterDesignationEntity saveOrUpdate(LetterDesignationEntity object) {
        beginTransaction();
        getSession().saveOrUpdate(object);
        endTransaction();

        return object;
    }
}