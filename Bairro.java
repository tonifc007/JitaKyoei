package br.ufpi.pdsi2.bairroAluno;

import static org.junit.Assert.assertEquals;

import org.fpij.jitakyoei.facade.AppFacade;
import org.fpij.jitakyoei.facade.AppFacadeImpl;
import org.fpij.jitakyoei.model.beans.Aluno;
import org.fpij.jitakyoei.model.beans.Endereco;
import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.view.AppView;
import org.fpij.jitakyoei.view.MainAppView;
import org.junit.Test;

public class Bairro {
	AppView view = new MainAppView();
	AppFacade facade = new AppFacadeImpl(view);
	
	@Test(expected=Exception.class)
	public void testBairroNullInvalido() throws Exception{
		
		String bairro = null;
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);	
	}
	
	@Test
	public void testBairroValido() {
		
		String bairro = "Centro";
		
		Endereco endereco = new Endereco();
		endereco.setRua(bairro);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String bairrocadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEndereco().getBairro();
		
		assertEquals("Não são iguais", bairro, bairrocadastrado);

	}
}
