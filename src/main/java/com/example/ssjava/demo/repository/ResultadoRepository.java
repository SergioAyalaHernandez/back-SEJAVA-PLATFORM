package com.example.ssjava.demo.repository;

import com.example.ssjava.demo.entity.ResultadoExamen;
import com.example.ssjava.demo.projection.DistribucionCalificacionesProjection;
import com.example.ssjava.demo.projection.PromedioResultadosPorCursoProjection;
import com.example.ssjava.demo.projection.TasaAprobacionPorCursoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ResultadoRepository extends ListCrudRepository<ResultadoExamen,Long> {
    List<ResultadoExamen> findAllByPersona_IdPersona(Long idPersona);

    @Query(value = "SELECT c.nombre, AVG(re.resultado) as promedio \n" +
            "FROM resultado_examen re\n" +
            "JOIN examen e ON re.id_examen = e.id_examen\n" +
            "JOIN cursos c ON e.id_curso = c.id_cursos\n" +
            "GROUP BY c.nombre;", nativeQuery = true)
    List<PromedioResultadosPorCursoProjection> findPromedioResultadosPorCurso();

    @Query(value = "SELECT c.nombre, re.resultado\n" +
            "FROM resultado_examen re\n" +
            "JOIN examen e ON re.id_examen = e.id_examen\n" +
            "JOIN cursos c ON e.id_curso = c.id_cursos;", nativeQuery = true)
    List<DistribucionCalificacionesProjection> findDistribucionCalificaciones();

    @Query(value = "SELECT c.nombre, \n" +
            "       SUM(CASE WHEN re.resultado >= 0.60 THEN 1 ELSE 0 END) / COUNT(*) * 100 AS tasa_aprobacion\n" +
            "FROM resultado_examen re\n" +
            "JOIN examen e ON re.id_examen = e.id_examen\n" +
            "JOIN cursos c ON e.id_curso = c.id_cursos\n" +
            "GROUP BY c.nombre;",nativeQuery = true)
    List<TasaAprobacionPorCursoProjection> findTasaAprobacionPorCurso();
}
