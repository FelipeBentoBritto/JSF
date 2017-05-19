package br.com.felipe.jsf.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = {"Faces Servlet"})
public class JPAFilter implements Filter{
	
	private EntityManagerFactory entityManagerFactory;
	
	private String persistence_unit_name = "unit_app";
	
	public JPAFilter() {
	}
	
	@Override
	public void destroy() {
		this.entityManagerFactory.close();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//CRIANDO UM ENTITY MANAGER
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		
		//ADICIONANDO ELE NA REQUISIÇÃO
		request.setAttribute("entityManager", entityManager);
		
		//INICIANDO UMA TRANSAÇÃO
		entityManager.getTransaction().begin();
		
		//INICIANDO FACES SERVLET
		chain.doFilter(request, response);
		
		try {
			//SE NÃO TIVER ERRO NA OPERAÇÃO ELE EXUTA O COMMIT
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			//SE TIVER ERRO NA OPERAÇÃO É EXECUTADO O ROLLBACK
			entityManager.getTransaction().rollback();
		} finally {
			//DEPOIS DE DAR O COMMIT OU ROLLBACK ELE FINALIZA O entityManager
			entityManager.close();
		} 
	}
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		//CRIA O entityManagerFactory COM OS PARÂMETROS DEFINIDOS NO persistence.xml
		this.entityManagerFactory = Persistence.createEntityManagerFactory(this.persistence_unit_name);
	}

}
