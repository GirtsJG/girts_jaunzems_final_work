package lv.lu.finalwork.repository;

import lv.lu.finalwork.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@org.springframework.stereotype.Repository
public class ProductOrmRepository implements Repository <Product>{

    private final SessionFactory sessionFactory;

    @Autowired

    public ProductOrmRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(Product entity) {
        return (Long) this.sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public List<Product> findAll() {
        return this.sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    }

    @Override
    public Product findById(Long id) {
        return this.sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public void delete(Long id) {
        final Product product = this.sessionFactory.getCurrentSession().get(Product.class, id);
        this.sessionFactory.getCurrentSession().delete(product);

    }
}
