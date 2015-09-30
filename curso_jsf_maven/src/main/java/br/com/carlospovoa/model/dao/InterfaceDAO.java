package br.com.carlospovoa.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface InterfaceDAO<T> {
    
   void save (T entity);
   void update (T entity);
   void delete (T entity);
   void merge (T entity);

   T getEntity(Serializable id);
   T getEntityByDetachedCriteria(DetachedCriteria criteria);
   List<T> getListByDetachedCriteria(DetachedCriteria criteria);
   List<T> getEntities();
  
   
}
