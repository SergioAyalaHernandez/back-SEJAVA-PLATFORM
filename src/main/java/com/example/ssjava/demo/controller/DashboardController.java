package com.example.ssjava.demo.controller;

import com.example.ssjava.demo.projection.*;
import com.example.ssjava.demo.service.DashBoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashBoardService dashBoardService;

    @GetMapping("/estudiantes-por-plan")
    public List<EstudiantesPorPlanProjection> getEstudiantesPorPlan() {
        return dashBoardService.getEstudiantesPorPlan();
    }

    @GetMapping("/promedio-resultados-por-curso")
    public List<PromedioResultadosPorCursoProjection> getPromedioResultadosPorCurso() {
        return dashBoardService.getPromedioResultadosPorCurso();
    }

    @GetMapping("/distribucion-calificaciones")
    public List<DistribucionCalificacionesProjection> getDistribucionCalificaciones() {
        return dashBoardService.getDistribucionCalificaciones();
    }

    @GetMapping("/tasa-aprobacion-por-curso")
    public List<TasaAprobacionPorCursoProjection> getTasaAprobacionPorCurso() {
        return dashBoardService.getTasaAprobacionPorCurso();
    }

    @GetMapping("/clases-por-profesor")
    public List<ClasesPorProfesorProjection> getClasesPorProfesor() {
        return dashBoardService.getClasesPorProfesor();
    }

    @GetMapping("/preguntas-por-examen")
    public List<PreguntasPorExamenProjection> getPreguntasPorExamen() {
        return dashBoardService.getPreguntasPorExamen();
    }

    @GetMapping("/preguntas-mas-acertadas")
    public List<PreguntasAcertadasProjection> getPreguntasMasAcertadas() {
        return dashBoardService.getPreguntasMasAcertadas();
    }

    @GetMapping("/preguntas-menos-acertadas")
    public List<PreguntasAcertadasProjection> getPreguntasMenosAcertadas() {
        return dashBoardService.getPreguntasMenosAcertadas();
    }

    @GetMapping("/usuarios-activos-por-mes")
    public List<UsuariosActivosPorMesProjection> getUsuariosActivosPorMes() {
        return dashBoardService.getNuevosUsuariosPorMes();
    }

    @GetMapping("/nuevos-usuarios-por-mes")
    public List<UsuariosActivosPorMesProjection> getNuevosUsuariosPorMes() {
        return dashBoardService.getNuevosUsuariosPorMes();
    }
}

