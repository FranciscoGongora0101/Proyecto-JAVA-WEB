package Entity;

import Entity.Estado;
import Entity.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-24T08:49:29")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, String> Nombre;
    public static volatile ListAttribute<Ciudad, Vuelo> origenList;
    public static volatile SingularAttribute<Ciudad, Long> id;
    public static volatile SingularAttribute<Ciudad, Estado> Estado;
    public static volatile ListAttribute<Ciudad, Vuelo> destinoList;

}