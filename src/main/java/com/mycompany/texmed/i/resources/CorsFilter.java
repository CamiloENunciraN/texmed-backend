/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texmed.i.resources;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import java.io.IOException;

/**
 *
 * @author Docente
 */
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
        MultivaluedMap<String, Object> headers = crc1.getHeaders();

        // Permitir peticiones desde cualquier origen
        headers.add("Access-Control-Allow-Origin", "*");

        // Permitir los métodos HTTP permitidos
        headers.add("Access-Control-Allow-Methods", "POST, GET, OPTI"
                + "ONS, DELETE, PUT");

        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");

        // Agregar otros encabezados personalizados si es necesario
        // headers.add("Access-Control-Allow-Headers", "header1, header2");
        // Configurar la caché de preflight por 12 horas
        headers.add("Access-Control-Max-Age", "43200");

        // Permitir el envío de cookies y otros encabezados específicos
        headers.add("Access-Control-Allow-Credentials", "true");
    }

}
