package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluguel.class)
public abstract class Aluguel_ {

	public static volatile SingularAttribute<Aluguel, Float> valorReceber;
	public static volatile SingularAttribute<Aluguel, Date> dataEncerramento;
	public static volatile SingularAttribute<Aluguel, Cliente> idCliente;
	public static volatile CollectionAttribute<Aluguel, Finalizaraluguel> finalizaraluguelCollection;
	public static volatile SingularAttribute<Aluguel, Date> dataEntrada;
	public static volatile SingularAttribute<Aluguel, Integer> id;
	public static volatile SingularAttribute<Aluguel, Quartos> idQuartos;
	public static volatile SingularAttribute<Aluguel, Boolean> status;

}

