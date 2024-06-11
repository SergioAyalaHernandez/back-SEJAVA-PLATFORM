package com.example.ssjava.demo.service.impl;

import com.example.ssjava.demo.dto.RespuestaExamenDto;
import com.example.ssjava.demo.entity.*;
import com.example.ssjava.demo.excepciones.BadRequestException;
import com.example.ssjava.demo.excepciones.NotFoundException;
import com.example.ssjava.demo.repository.*;
import com.example.ssjava.demo.service.ResultadoExamenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResultadoExamenServiceImpl implements ResultadoExamenService {

    private ResultadoRepository resultadoExamenRepository;
    private RespuestasAlumnoRepository respuestasAlumnoRepository;
    private PersonaRepository personaRepository;
    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;
    private RespuestaRepository respuestaRepository;

    @Override
    public ResultadoExamen createResultadoExamen(RespuestaExamenDto resultadoExamen) {
        ResultadoExamen examenBase = new ResultadoExamen();
        Optional<ExamenEntity> examenRealizado = examenRepository.findById(resultadoExamen.getIdExamen());
        Optional<PersonaEntity> persona= personaRepository.findById(resultadoExamen.getIdPersona());
        if (persona.isPresent() && examenRealizado.isPresent()){
            examenBase.setPersona(persona.get());
            examenBase.setExamen(examenRealizado.get());
            examenBase = resultadoExamenRepository.save(examenBase);
            Optional<ExamenEntity> examenEntity = examenRepository.findById(resultadoExamen.getIdExamen());

            if (examenEntity.isPresent()) {
                float calificacion = guardarNotas(resultadoExamen, examenEntity, examenBase);
                examenBase.setResultado(calificacion/10);
                resultadoExamenRepository.save(examenBase);
                return examenBase;
            } else {
                throw new NotFoundException("El examen con el ID especificado no existe.");
            }
        }else{
            throw new NotFoundException("El usuario no existe.");
        }
    }

    private float guardarNotas(RespuestaExamenDto resultadoExamen, Optional<ExamenEntity> examenEntity, ResultadoExamen resultadoExamendb) {
        if (examenEntity.isPresent()) {
            ExamenEntity examen = examenEntity.get();
            List<Long> idPreguntas = resultadoExamen.getIdPreguntas();
            List<Long> idRespuestas = resultadoExamen.getIdRespuestas();

            if (idPreguntas.size() == idRespuestas.size()) {
                float calificacion = 0;

                for (int i = 0; i < idPreguntas.size(); i++) {
                    Long idPregunta = idPreguntas.get(i);
                    Long idRespuesta = idRespuestas.get(i);

                    Optional<PreguntaEntity> preguntaEntity = preguntaRepository.findById(idPregunta);
                    Optional<RespuestaEntity> respuestaEntity = respuestaRepository.findById(Math.toIntExact(idRespuesta));

                    if (preguntaEntity.isPresent() && respuestaEntity.isPresent()) {
                        RespuestasAlumnoEntity respuestasAlumnoEntity = new RespuestasAlumnoEntity();
                        respuestasAlumnoEntity.setPregunta(preguntaEntity.get());
                        respuestasAlumnoEntity.setRespuesta(respuestaEntity.get());
                        respuestasAlumnoEntity.setExamen(examen);
                        respuestasAlumnoEntity.setResultadoExamen(resultadoExamendb);
                        respuestasAlumnoRepository.save(respuestasAlumnoEntity);

                        if (preguntaEntity.get().getIdPregunta() == respuestaEntity.get().getPregunta().getIdPregunta() && respuestaEntity.get().isEsCorrecta()) {
                            calificacion++;
                        }
                    } else {
                        throw new BadRequestException("Pregunta o Respuesta no encontrada para el ID proporcionado.");
                    }
                }
                return calificacion;
            } else {
                throw new BadRequestException("Las listas de preguntas y respuestas deben tener el mismo tamaño.");
            }
        } else {
            throw new NotFoundException("No existe el examen adjuntado.");
        }
    }

    @Override
    public List<ResultadoExamen> getAllResultById(Long id) {
        return resultadoExamenRepository.findAllByPersona_IdPersona(id);
    }
}
