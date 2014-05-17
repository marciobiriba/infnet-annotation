package br.edu.infnet.framework.renderizador;

import java.lang.reflect.Field;

import br.edu.infnet.framework.annotation.FormHtml;
import br.edu.infnet.framework.annotation.InputText;

public abstract class HtmlRenderizador {
	private StringBuffer html;
	public HtmlRenderizador(){
		gerarHtml();
	}
	private void gerarHtml() {
		html = new StringBuffer();
		html.append("<htm>");
		html.append("<head></head>");
		html.append("<body>");
		Class<? extends HtmlRenderizador> classe = this.getClass();
		FormHtml form = (FormHtml) classe.getAnnotation(FormHtml.class);
		if(form != null){
			html.append("<form name = '" + form.nome() + "'>");
		}
		Field [] fields = classe.getDeclaredFields();
		for(Field campo : fields){
			if(campo.isAnnotationPresent(InputText.class)){
				InputText text = campo.getAnnotation(InputText.class);
				html.append("<input type='text' name='");
				html.append(text.nome());
				html.append("'");
				html.append(" maxlength='");
				html.append(text.tamanho());
				html.append("'/>");
			}
		}
		if(form != null){
			html.append("</form>");
		}
		html.append("</body>");
		html.append("</html>");
	}
	@Override
	public String toString(){
		return this.html.toString();
	}
}
