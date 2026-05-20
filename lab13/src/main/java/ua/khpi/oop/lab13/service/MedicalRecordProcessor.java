package ua.khpi.oop.lab13.service;

import ua.khpi.oop.lab13.model.PatientVisit;
import ua.khpi.oop.lab13.model.VisitReport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MedicalRecordProcessor {
    private static final Pattern MEDICAL_RECORD_PATTERN = Pattern.compile(
            "^(\\d{4}-\\d{2}-\\d{2}) \\| (PAT-\\d{3}) \\| ([A-Za-z ]+) \\| ([A-Za-z ]+) \\| (.+)$"
    );

    public static String normalizeWhitespace(String line) {
        if (line == null) {
            return "";
        }

        return line.trim().replaceAll("\\s+", " ");
    }

    public PatientVisit parseLine(String rawLine) {
        String normalizedLine = normalizeWhitespace(rawLine);
        Matcher matcher = MEDICAL_RECORD_PATTERN.matcher(normalizedLine);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid medical record: " + rawLine);
        }

        LocalDate visitDate = LocalDate.parse(matcher.group(1));
        String patientCode = matcher.group(2);
        String patientName = matcher.group(3);
        String department = matcher.group(4);
        String prescription = matcher.group(5);

        return new PatientVisit(
                visitDate,
                patientCode,
                patientName,
                department,
                prescription
        );
    }

    public List<PatientVisit> parseLines(List<String> rawLines) {
        List<PatientVisit> visits = new ArrayList<>();

        for (String rawLine : rawLines) {
            String normalizedLine = normalizeWhitespace(rawLine);

            if (!normalizedLine.isBlank()) {
                visits.add(parseLine(normalizedLine));
            }
        }

        return visits;
    }

    public List<PatientVisit> parseOnlyValidLines(List<String> rawLines) {
        List<PatientVisit> visits = new ArrayList<>();

        for (String rawLine : rawLines) {
            try {
                String normalizedLine = normalizeWhitespace(rawLine);

                if (!normalizedLine.isBlank()) {
                    visits.add(parseLine(normalizedLine));
                }
            } catch (IllegalArgumentException ignored) {
            }
        }

        return visits;
    }

    public VisitReport summarize(List<PatientVisit> visits) {
        int therapyVisits = 0;
        int cardiologyVisits = 0;

        for (PatientVisit visit : visits) {
            if (visit.department().equalsIgnoreCase("Therapy")) {
                therapyVisits++;
            }

            if (visit.department().equalsIgnoreCase("Cardiology")) {
                cardiologyVisits++;
            }
        }

        return new VisitReport(
                visits.size(),
                therapyVisits,
                cardiologyVisits
        );
    }

    public String buildReport(List<PatientVisit> visits) {
        VisitReport summary = summarize(visits);
        StringBuilder report = new StringBuilder();

        report.append("Medical visits report\n");
        report.append("=====================\n");
        report.append("Total valid visits: ").append(summary.totalVisits()).append('\n');
        report.append("Therapy visits: ").append(summary.therapyVisits()).append('\n');
        report.append("Cardiology visits: ").append(summary.cardiologyVisits()).append("\n\n");

        report.append("Visits:\n");

        for (PatientVisit visit : visits) {
            report.append("- ")
                    .append(visit.visitDate()).append(" | ")
                    .append(visit.patientCode()).append(" | ")
                    .append(visit.patientName()).append(" | ")
                    .append(visit.department()).append(" | ")
                    .append(visit.prescription())
                    .append('\n');
        }

        return report.toString();
    }
}