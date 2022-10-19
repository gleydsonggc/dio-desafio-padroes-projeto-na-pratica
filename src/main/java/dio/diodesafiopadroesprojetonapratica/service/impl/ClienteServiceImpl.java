package dio.diodesafiopadroesprojetonapratica.service.impl;

import dio.diodesafiopadroesprojetonapratica.model.Cliente;
import dio.diodesafiopadroesprojetonapratica.model.Endereco;
import dio.diodesafiopadroesprojetonapratica.repository.ClienteRepository;
import dio.diodesafiopadroesprojetonapratica.repository.EnderecoRepository;
import dio.diodesafiopadroesprojetonapratica.service.ClienteService;
import dio.diodesafiopadroesprojetonapratica.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository clienteRepository;
	private final EnderecoRepository enderecoRepository;
	private final ViaCepService viaCepService;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		clienteRepository.findById(id)
				.ifPresent(c -> salvarClienteComCep(cliente));
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
