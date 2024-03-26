package io.shaikezam.persistence.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Converter(autoApply = true)
public class TimestampToLocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    private static final Logger logger = Logger.getLogger(TimestampToLocalDateTimeAttributeConverter.class.getName());

    @Override
    public Timestamp convertToDatabaseColumn(final LocalDateTime localDateTime) {
        return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(final Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime();
    }
}
