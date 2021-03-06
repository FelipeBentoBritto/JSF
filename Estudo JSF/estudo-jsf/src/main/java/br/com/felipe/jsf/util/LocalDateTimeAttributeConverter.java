package br.com.felipe.jsf.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

	//TRANSFORMAR EM Timestamp NA HORA DE PERSISTIR NO BD
	
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
		if (localDateTime != null)
			return Timestamp.valueOf(localDateTime);
		
		return null;
	}
	
	//TRANSFORMAR UM Timestamp EM LocalDateTime QUANDO RETORNAR DO BANCO PARAR ENTIDADE
	
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
		if(timestamp != null) {
			return timestamp.toLocalDateTime();
		}
		return null;
	}
}
