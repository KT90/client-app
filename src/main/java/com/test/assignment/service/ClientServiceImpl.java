package com.test.assignment.service;

import com.test.assignment.model.Client;
import com.test.assignment.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClient(long id) {
        return clientRepository.getById(id);
    }

    public Client add(Client client) {
        return clientRepository.save(client);
    }


}
