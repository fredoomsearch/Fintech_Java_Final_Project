package com.bolsadeideas.springboot.app.models.service;

import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.app.models.DTO.ScoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
		public List<Cliente> findAll() {
			// TODO Auto-generated method stub
			return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}
	@Override
	public String procesarSolicitud(Long id) {

		boolean score = Boolean.FALSE;
		boolean reportado = Boolean.FALSE;
		boolean cuenta = Boolean.FALSE;
		boolean habilitado = Boolean.FALSE;
		boolean cedula = Boolean.FALSE;

		String motivoRechazo = "";

		//consultarCliente Por Id
		Cliente cliente = clienteDao.findById(id).get();
		//Consumir API
		String url = "";
		if (id % 2 == 0) {
			url = "https://run.mocky.io/v3/b9a4b435-e479-4369-a0f1-7e222f88f9d6";
		} else {
			url = "https://run.mocky.io/v3/824d579f-4e0f-4a83-856d-dc61341550e4";
		}
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ScoreDTO> response =
				restTemplate.exchange(
						url,
						HttpMethod.GET,
						new HttpEntity<>(null),
						ScoreDTO.class);
		ScoreDTO scoreDto = response.getBody();
		//Hacer validaciones
		if (scoreDto.getScore() > 600) {
			score = Boolean.TRUE;
		} else {
			motivoRechazo = motivoRechazo + " -Score menor a 600";
		}

		//...

		if (cliente.getFoto().contains("cedula")) {
			cedula = Boolean.TRUE;
		} else {
			motivoRechazo = motivoRechazo + " -No dice cedula";
		}

		if (scoreDto.getHabilitado() == 0) {
			score = Boolean.TRUE;
		} else {
			motivoRechazo = motivoRechazo + " -Score menor a 600";
		}

		//Tomar a decisión
		if (score && reportado && cuenta && habilitado && cedula) {
			return "aprobado";
		} else {
			return motivoRechazo;
		}
	}

	@Override
	public String validacionFoto(String foto) {

		if (foto != null && !foto.isEmpty()) {
			// The client has a photo
			// You can add your photo validation logic here
			// For example, check if the photo exists in your storage
			return "Cliente tiene foto";
		} else {
			// The client does not have a photo
			return "Cliente no tiene foto";
		}

	}




	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}
}
