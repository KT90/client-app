package com.test.assignment.controller;

import com.test.assignment.model.Client;
import com.test.assignment.model.Sector;
import com.test.assignment.service.ClientService;
import com.test.assignment.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private SectorService sectorService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getClient(ModelMap model, HttpSession httpSession) {
        Client clientSessionData = (Client) httpSession.getAttribute("clientSessionData");
        if (clientSessionData != null) {
            model.addAttribute("client", clientSessionData);
        } else {
            Client client = new Client();
            model.addAttribute("client", client);
        }
        List<Sector> sectors = sectorService.getAllParentSectors();
        model.addAttribute("sectorsList", sectors);
        return "clientForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addClient(@Valid Client client, BindingResult bindingResult, ModelMap model, HttpSession httpSession) {
        List<Sector> sectors = sectorService.getAllParentSectors();
        model.addAttribute("sectorsList", sectors);
        if (bindingResult.hasErrors()) {
            return "clientForm";
        }
        Client clientData = clientService.add(client);
        model.addAttribute("client", clientData);
        httpSession.setAttribute("clientSessionData", clientData);
        return "clientForm";
    }

}
