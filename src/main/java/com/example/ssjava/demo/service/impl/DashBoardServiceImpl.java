package com.example.ssjava.demo.service.impl;

import com.example.ssjava.demo.projection.*;
import com.example.ssjava.demo.repository.*;
import com.example.ssjava.demo.service.DashBoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@AllArgsConstructor
public class DashBoardServiceImpl implements DashBoardService {

    private final PlanRepository planRepository;
    private final ResultadoRepository resultadoExamenRepository;
    private final ClaseRepository claseRepository;
    private final PreguntaRepository preguntaRepository;
    private final RespuestasAlumnoRepository respuestaAlumnoRepository;
    private final PersonaRepository personaRepository;


    @Override
    public List<EstudiantesPorPlanProjection> getEstudiantesPorPlan() {
        return planRepository.findEstudiantesPorPlan();
    }
    @Override
    public List<PromedioResultadosPorCursoProjection> getPromedioResultadosPorCurso() {
        return resultadoExamenRepository.findPromedioResultadosPorCurso();
    }

    @Override
    public List<DistribucionCalificacionesProjection> getDistribucionCalificaciones() {
        return resultadoExamenRepository.findDistribucionCalificaciones();
    }
    @Override
    public List<TasaAprobacionPorCursoProjection> getTasaAprobacionPorCurso() {
        return resultadoExamenRepository.findTasaAprobacionPorCurso();
    }
    @Override
    public List<ClasesPorProfesorProjection> getClasesPorProfesor() {
        return claseRepository.findClasesPorProfesor();
    }
    @Override
    public List<PreguntasPorExamenProjection> getPreguntasPorExamen() {
        return preguntaRepository.findPreguntasPorExamen();
    }

    @Override
    public List<PreguntasAcertadasProjection> getPreguntasMasAcertadas() {
        return respuestaAlumnoRepository.findPreguntasMasAcertadas();
    }

    @Override
    public List<PreguntasAcertadasProjection> getPreguntasMenosAcertadas() {
        return respuestaAlumnoRepository.findPreguntasMenosAcertadas();
    }
    @Override
    public List<UsuariosActivosPorMesProjection> getNuevosUsuariosPorMes() {
        return personaRepository.findNuevosUsuariosPorMes();
    }
}
