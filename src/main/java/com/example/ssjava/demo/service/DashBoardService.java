package com.example.ssjava.demo.service;

import com.example.ssjava.demo.projection.*;

import java.awt.print.Pageable;
import java.util.List;

public interface DashBoardService {
    List<EstudiantesPorPlanProjection> getEstudiantesPorPlan();
    List<PromedioResultadosPorCursoProjection> getPromedioResultadosPorCurso();
    List<DistribucionCalificacionesProjection> getDistribucionCalificaciones();
    List<TasaAprobacionPorCursoProjection> getTasaAprobacionPorCurso();
    List<ClasesPorProfesorProjection> getClasesPorProfesor();
    List<PreguntasPorExamenProjection> getPreguntasPorExamen();
    List<PreguntasAcertadasProjection> getPreguntasMasAcertadas();
    List<PreguntasAcertadasProjection> getPreguntasMenosAcertadas();
    List<UsuariosActivosPorMesProjection> getNuevosUsuariosPorMes();
}

