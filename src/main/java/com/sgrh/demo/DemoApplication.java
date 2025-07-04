package com.sgrh.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sgrh.demo.repositorio.AsistenciaRepository;
import com.sgrh.demo.repositorio.CertificadoRepository;
import com.sgrh.demo.repositorio.DetalleNominaRepository;
import com.sgrh.demo.repositorio.EmpresaRepository;
import com.sgrh.demo.repositorio.InformeRepository;
import com.sgrh.demo.repositorio.NominaRepository;
import com.sgrh.demo.repositorio.PermisoRepository;
import com.sgrh.demo.repositorio.PersonaRepository;
import com.sgrh.demo.repositorio.ReporteRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired private EmpresaRepository empresaRepository;
    @Autowired private PersonaRepository personaRepository;
    @Autowired private NominaRepository nominaRepository;
    @Autowired private DetalleNominaRepository detalleNominaRepository;
    @Autowired private CertificadoRepository certificadoRepository;
    @Autowired private AsistenciaRepository asistenciaRepository;
    @Autowired private PermisoRepository permisoRepository;
    @Autowired private ReporteRepository reporteRepository;
    @Autowired private InformeRepository informeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            System.out.println("✅ Inicio correcto del sistema:");
            System.out.println("   - Empresas: " + empresaRepository.count());
            System.out.println("   - Personas: " + personaRepository.count());
            System.out.println("   - Nóminas: " + nominaRepository.count());
            System.out.println("   - Detalle Nómina: " + detalleNominaRepository.count());
            System.out.println("   - Certificados: " + certificadoRepository.count());
            System.out.println("   - Asistencias: " + asistenciaRepository.count());
            System.out.println("   - Permisos: " + permisoRepository.count());
            System.out.println("   - Reportes: " + reporteRepository.count());
            System.out.println("   - Informes: " + informeRepository.count());
        } catch (Exception e) {
            System.err.println("❌ Error al iniciar repositorios: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

