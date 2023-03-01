package com.project.message.messagerealtime.constraint;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {

//        StringBuilder builder = new StringBuilder();
//
//        builder.append(UUID.randomUUID().toString(), 0, 7);
        return UUID.randomUUID().toString();
    }
}
