package Entity;

import Entity.Avion;
import Entity.Ciudad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-03T17:42:52")
@StaticMetamodel(Vuelo.class)
public class Vuelo_ { 

    public static volatile SingularAttribute<Vuelo, Date> Fecha_Inicio;
    public static volatile SingularAttribute<Vuelo, Ciudad> Destino;
    public static volatile SingularAttribute<Vuelo, String> Numero_Vuelo;
    public static volatile SingularAttribute<Vuelo, Integer> Numero_Pasajeros;
    public static volatile SingularAttribute<Vuelo, Date> Hora_Final_Vuelo;
    public static volatile SingularAttribute<Vuelo, Avion> Avion;
    public static volatile SingularAttribute<Vuelo, Date> Fecha_Final_Vuelo;
    public static volatile SingularAttribute<Vuelo, Long> id;
    public static volatile SingularAttribute<Vuelo, Ciudad> Origen;
    public static volatile SingularAttribute<Vuelo, Date> Hora_Inicio_Vuelo;

}