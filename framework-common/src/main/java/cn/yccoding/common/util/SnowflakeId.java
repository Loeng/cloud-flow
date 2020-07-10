package cn.yccoding.common.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 自定义主键策略--雪花算法
 *
 * @author YC
 * @since 2020/7/10
 **/
public class SnowflakeId implements IdentifierGenerator {

    private static Sequence worker = new Sequence();

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return String.valueOf(worker.nextId());
    }
}
