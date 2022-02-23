package com.test.assignment.service;

import com.test.assignment.model.Client;

public interface ClientService {

    public Client getClient(long id);

    public Client add(Client client);
}
