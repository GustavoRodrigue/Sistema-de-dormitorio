package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Quartos.class)
public abstract class Quartos_ {

	public static volatile SingularAttribute<Quartos, String> tipoQuartos;
	public static volatile CollectionAttribute<Quartos, Aluguel> aluguelCollection;
	public static volatile SingularAttribute<Quartos, Float> valorQuarto;
	public static volatile SingularAttribute<Quartos, Integer> id;

}

