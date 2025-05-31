package converter;

import entity.Birthday;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.util.Optional;

@Converter(autoApply = true)
public class BirthDayConverter implements AttributeConverter<Birthday, Date> {
    @Override
    public Date convertToDatabaseColumn(Birthday birthday) {
        return Optional.ofNullable(birthday)
            .map(Birthday::birthday)
            .map(Date::valueOf)
            .orElse(null);
    }

    @Override
    public Birthday convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
            .map(Date::toLocalDate)
            .map(Birthday::new)
            .orElse(null);
    }
}
