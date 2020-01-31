package Entity;

import Entity.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-31T01:01:43")
@StaticMetamodel(Avion.class)
public class Avion_ { 

    public static volatile SingularAttribute<Avion, Integer> Cantidad_Pasajeros;
    public static volatile ListAttribute<Avion, Vuelo> avionList;
    public static volatile SingularAttribute<Avion, String> Modelo;
    public static volatile SingularAttribute<Avion, String> Aerolinea;
    public static volatile SingularAttribute<Avion, Long> id;
    public static volatile SingularAttribute<Avion, String> Numero_Avion;

}