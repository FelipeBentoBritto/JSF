package br.com.felipe.jsf.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="classeConverter")
public class ClasseConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Classe) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if(value instanceof Classe) {
			Classe entity = (Classe) value;
			if(entity != null && entity instanceof Classe && entity.getCodigo() != null) {
				uiComponent.getAttributes().put(entity.getCodigo().toString(), entity);
				return entity.getCodigo().toString();
			}
		}
		
		
		return "";
	}

}
