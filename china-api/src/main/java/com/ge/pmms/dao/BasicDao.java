package com.ge.pmms.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.multipart.MultipartFile;



/**
 * Common Data Access Object.
 *
 * @author Sohail Shaikh
 *
 */
public abstract class BasicDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
    /*@Autowired
    private SessionFactory sessionFactory;*/
    
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Get the current Hibernate session from session factory.
     *
     * @return the Hibernate session
     */
    protected final Session getSession() {
    	return entityManager.unwrap(Session.class);
    }
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	/**
     * Get entity by ID.
     *
     * @param <T>
     *            the Entity Generic Type
     * @param entityType
     *            the Persistent Entity Type
     * @param id
     *            the entity ID
     * @return the Entity Object
     */
	public <T extends Serializable> T get(final Class<T> entityType,
            final Serializable id) {

        T entity = null;

        // @formatter:off
        /*
        // Using Criteria
        entity = (T) getSession().createCriteria(entityType)
                .add(Restrictions.idEq(id))
                .uniqueResult();

        // Using HQL
        entity = (T) getSession().createQuery(
                "from " + entityType.getName() + " where id = ?")
                .setLong(0, id)
                .uniqueResult();
        */
        // @formatter:on

        // Using Identifier
        //entity = (T) getSession().get(entityType, id);
        entity = (T) entityManager.find(entityType, id);

        return entity;
    }

    /**
     * Get a list of all entities.<br>
     * Database caching is not used.
     *
     * @param <T>
     *            the Entity Generic Type
     * @param entityType
     *            the Persistent Entity Type
     * @return A list of all entities
     */
    public <T extends Serializable> List<T> list(final Class<T> entityType) {
        return list(entityType, false);
    }

    /**
     * Get a list of all entities.
     *
     * @param <T>
     *            the Entity Generic Type
     * @param entityType
     *            the Persistent Entity Type
     * @param useCache
     *            to use database caching or not
     * @return A list of all entities
     */
    @SuppressWarnings("unchecked")
    public <T extends Serializable> List<T> list(final Class<T> entityType,
            final boolean useCache) {

        List<T> entityList = null;

        // @formatter:off
        /*
        // Using Criteria
        entityList = getSession()
                .createCriteria(getEntityClass())
                .setResultTransformer(
                        CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
        */
        // Using HQL
        entityList = getSession().createQuery("from " + entityType.getName())
                .setCacheable(useCache)
                .list();

        // @formatter:on

        return entityList;
    }

    /**
     * Save/Update the entity.
     *
     * @param <T>
     *            the Entity Generic Type
     * @param entity
     *            the entity to save/update
     */
    public <T extends Serializable> void saveOrUpdate(final T entity) {
        getSession().saveOrUpdate(entity);
    }

    /**
     * Merge the entity.
     *
     * @param <T>
     *            the Entity Generic Type
     * @param entity
     *            the entity to merge
     */
    @SuppressWarnings("unchecked")
    public <T> T merge(final T entity) {
        return (T) getSession().merge(entity);
    }
    
    /**
     * Delete the entity.
     *
     * @param <T>
     *            the Entity Generic Type
     * @param entity
     *            the entity to delete
     */
    public <T extends Serializable> void delete(final T entity) {
        getSession().delete(entity);
    }

    /**
     * Delete the entity by ID.
     *
     * @param <T>
     *            the Entity Generic Type
     * @param entityType
     *            the Persistent Entity Type
     * @param id
     *            the entity ID
     */
    public <T extends Serializable> void deleteById(
            final Class<T> entityType, final long id) {
        final T entity = get(entityType, id);
        delete(entity);
    }

	public String uploadPicturesForWorkOrder(MultipartFile file, String woId, byte[] filebytes) {
		// TODO Auto-generated method stub
		return null;
	}


	
	}


