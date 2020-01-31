package Entity;

import Entity.Estado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-31T01:01:43")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> Nombre;
    public static volatile SingularAttribute<Pais, Long> id;
    public static volatile ListAttribute<Pais, Estado> paisList;

}