package Entity;

import Entity.Ciudad;
import Entity.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-24T08:49:29")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, String> Nombre;
    public static volatile ListAttribute<Estado, Ciudad> estadoList;
    public static volatile SingularAttribute<Estado, Long> id;
    public static volatile SingularAttribute<Estado, Pais> Pais;

}