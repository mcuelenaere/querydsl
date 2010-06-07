package com.mysema.query.sql;

import com.mysema.query.DefaultQueryMetadata;
import com.mysema.query.QueryMetadata;
import com.mysema.query.support.DetachableQuery;
import com.mysema.query.support.QueryMixin;
import com.mysema.query.types.expr.EBoolean;
import com.mysema.query.types.path.PEntity;

/**
 * Abstract superclass for SubQuery implementations
 * 
 * @author tiwe
 *
 */
public class AbstractSQLSubQuery<Q extends AbstractSQLSubQuery<Q>> extends DetachableQuery<Q> {
    
    
    /**
     * 
     */
    public AbstractSQLSubQuery() {
        this(new DefaultQueryMetadata());
    }
    
    /**
     * @param metadata
     */
    @SuppressWarnings("unchecked")
    public AbstractSQLSubQuery(QueryMetadata metadata) {
        super(new QueryMixin<Q>(metadata));
        this.queryMixin.setSelf((Q)this);
    }
        
    public Q from(PEntity<?>... args){
        return queryMixin.from(args);
    }
    
    public Q fullJoin(PEntity<?> target) {
        return queryMixin.fullJoin(target);
    }
    
    public Q innerJoin(PEntity<?> target) {
        return queryMixin.innerJoin(target);
    }
    
    public Q join(PEntity<?> target) {
        return queryMixin.join(target);
    }
    
    public Q leftJoin(PEntity<?> target) {
        return queryMixin.leftJoin(target);
    }
    
    public Q on(EBoolean... conditions){
        return queryMixin.on(conditions);
    }
    
    @Override
    public String toString(){
        if (!queryMixin.getMetadata().getJoins().isEmpty()){
            SQLSerializer serializer = new SQLSerializer(SQLTemplates.DEFAULT);
            serializer.serialize(queryMixin.getMetadata(), false);
            return serializer.toString().trim();
        }else{
            return super.toString();
        }        
    }

}