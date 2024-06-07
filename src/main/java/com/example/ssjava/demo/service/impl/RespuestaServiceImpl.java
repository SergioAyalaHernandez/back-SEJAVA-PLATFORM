package com.example.ssjava.demo.service.impl;

import com.example.ssjava.demo.entity.RespuestaEntity;
import com.example.ssjava.demo.projection.RespuestaProjection;
import com.example.ssjava.demo.repository.RespuestaRepository;
import com.example.ssjava.demo.service.RespuestaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RespuestaServiceImpl implements RespuestaService {

    private RespuestaRepository respuestaRepository;

    @Override
    public List<RespuestaEntity> getAllRespuestas() {
        return respuestaRepository.findAll();
    }

    @Override
    public Optional<RespuestaEntity> getRespuestaById(int id) {
        return respuestaRepository.findById(id);
    }

    @Override
    public RespuestaEntity createRespuesta(RespuestaEntity respuesta) {
        return respuestaRepository.save(respuesta);
    }

    @Override
    public RespuestaEntity updateRespuesta(int id, RespuestaEntity respuesta) {
        Optional<RespuestaEntity> existingRespuesta = respuestaRepository.findById(id);
        if (existingRespuesta.isPresent()) {
            RespuestaEntity updatedRespuesta = existingRespuesta.get();
            updatedRespuesta.setPregunta(respuesta.getPregunta());
            updatedRespuesta.setRespuesta(respuesta.getRespuesta());
            updatedRespuesta.setEsCorrecta(respuesta.isEsCorrecta());
            return respuestaRepository.save(updatedRespuesta);
        } else {
            throw new RuntimeException("Respuesta not found with id " + id);
        }
    }
    @Override
    public List<RespuestaProjection> getRespuestasByPreguntaIds(List<Integer> idPreguntas) {
        return respuestaRepository.findRespuestasByPreguntaIds(idPreguntas);
    }

}
