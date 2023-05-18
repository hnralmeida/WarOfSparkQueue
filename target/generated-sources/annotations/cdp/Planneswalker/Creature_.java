package cdp.Planneswalker;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-14T12:49:21", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Creature.class)
public abstract class Creature_ { 

    public static volatile SingularAttribute<Creature, Integer> maxEnergy;
    public static volatile SingularAttribute<Creature, Integer> ready;
    public static volatile SingularAttribute<Creature, String> name;
    public static volatile SingularAttribute<Creature, Integer> weight;
    public static volatile SingularAttribute<Creature, Integer> currentEnergy;
    public static volatile SingularAttribute<Creature, Integer> id;
    public static volatile SingularAttribute<Creature, Integer> age;

}