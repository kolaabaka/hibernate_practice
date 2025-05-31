package util;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import converter.BirthDayConverter;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory(){
        Configuration config = new Configuration();
//        config.setPhysicalNamingStrategy(); //choose name mapping entity -> database, example firstName -> first_name
//        config.addAnnotatedClass(User.class);
        config.addAttributeConverter(new BirthDayConverter());//, true);
        config.registerTypeOverride(new JsonBinaryType());
        config.configure(); //configure choose path to hibernate.cfg.xml, may be for example config.configure("tmp/cfg.xml")
        return config.buildSessionFactory();
    }
}
