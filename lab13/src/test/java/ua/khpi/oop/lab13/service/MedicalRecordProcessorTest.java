package ua.khpi.oop.lab13.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab13.model.PatientVisit;
import ua.khpi.oop.lab13.model.VisitReport;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicalRecordProcessorTest {
    private final MedicalRecordProcessor processor = new MedicalRecordProcessor();

    @Test
    void normalizesWhitespace() {
        String normalized = MedicalRecordProcessor.normalizeWhitespace(
                "  2026-04-10   |   PAT-001   |   Ivan Petrenko   |   Therapy   |   Aspirin 100mg  "
        );

        assertEquals("2026-04-10 | PAT-001 | Ivan Petrenko | Therapy | Aspirin 100mg", normalized);
    }

    @Test
    void parsesValidMedicalRecord() {
        PatientVisit visit = processor.parseLine(
                "2026-04-10 | PAT-001 | Ivan Petrenko | Therapy | Aspirin 100mg"
        );

        assertEquals("PAT-001", visit.patientCode());
        assertEquals("Ivan Petrenko", visit.patientName());
        assertEquals("Therapy", visit.department());
        assertEquals("Aspirin 100mg", visit.prescription());
    }

    @Test
    void rejectsInvalidPatientCode() {
        assertThrows(
                IllegalArgumentException.class,
                () -> processor.parseLine("2026-04-10 | P-1 | Ivan Petrenko | Therapy | Aspirin 100mg")
        );
    }

    @Test
    void rejectsInvalidDateFormat() {
        assertThrows(
                IllegalArgumentException.class,
                () -> processor.parseLine("2026/04/10 | PAT-001 | Ivan Petrenko | Therapy | Aspirin 100mg")
        );
    }

    @Test
    void parsesOnlyValidLines() {
        List<PatientVisit> visits = processor.parseOnlyValidLines(List.of(
                "2026-04-10 | PAT-001 | Ivan Petrenko | Therapy | Aspirin 100mg",
                "bad line",
                "2026-04-11 | PAT-002 | Olena Kovalenko | Cardiology | ECG"
        ));

        assertEquals(2, visits.size());
    }

    @Test
    void calculatesSummary() {
        List<PatientVisit> visits = processor.parseOnlyValidLines(List.of(
                "2026-04-10 | PAT-001 | Ivan Petrenko | Therapy | Aspirin 100mg",
                "2026-04-11 | PAT-002 | Olena Kovalenko | Cardiology | ECG",
                "2026-04-12 | PAT-003 | Andrii Shevchenko | Therapy | Vitamin D"
        ));

        VisitReport report = processor.summarize(visits);

        assertEquals(3, report.totalVisits());
        assertEquals(2, report.therapyVisits());
        assertEquals(1, report.cardiologyVisits());
    }

    @Test
    void buildsTextReport() {
        List<PatientVisit> visits = processor.parseOnlyValidLines(List.of(
                "2026-04-10 | PAT-001 | Ivan Petrenko | Therapy | Aspirin 100mg"
        ));

        String report = processor.buildReport(visits);

        assertTrue(report.contains("Total valid visits: 1"));
        assertTrue(report.contains("PAT-001"));
        assertTrue(report.contains("Ivan Petrenko"));
    }
}