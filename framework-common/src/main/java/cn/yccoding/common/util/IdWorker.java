package cn.yccoding.common.util;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * 自定义主键策略--雪花算法
 *
 * @author YC
 * @since 2020/7/10
 **/
public class IdWorker implements IdentifierGenerator {

    private static final Sequence worker = new Sequence();

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
        throws HibernateException {
        return String.valueOf(worker.nextId());
    }

}
