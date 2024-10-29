package com.example.ihm2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Reports extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> names;
    private ArrayList<String> details;
    private ReportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        listView = findViewById(R.id.listView);

        names = new ArrayList<>();
        details = new ArrayList<>();

        names.add("Reporte de Casos Judiciales");
        details.add("Es un documento que compila información relevante sobre los casos legales en curso, incluyendo su estado, partes involucradas, fechas de audiencias y resoluciones. Este tipo de reporte es fundamental para abogados, fiscales, y otros profesionales del derecho, ya que proporciona un panorama claro sobre el avance de los litigios y permite una mejor gestión de los mismos.");

        names.add("Informe de Cumplimiento Legal");
        details.add("Es un documento que evalúa si una organización o entidad está cumpliendo con las leyes y regulaciones aplicables. Este informe incluye detalles sobre políticas, procedimientos y prácticas implementadas para garantizar el cumplimiento normativo, así como cualquier incumplimiento identificado y las acciones correctivas propuestas. Es esencial para la gestión de riesgos legales y la promoción de la transparencia en las operaciones.");

        names.add("Reporte de Incidentes o Quejas");
        details.add("Documenta cualquier evento adverso o insatisfacción presentada por clientes o empleados. Incluye detalles del incidente, las partes involucradas y las acciones tomadas para resolverlo. Este informe es crucial para mejorar procesos y garantizar la satisfacción y seguridad en la organización.");

        names.add("Informe de Auditoría Legal");
        details.add("Evalúa la efectividad y cumplimiento de las políticas legales y normativas dentro de una organización. Este informe identifica áreas de mejora y asegura que las prácticas legales se alineen con los objetivos corporativos.");

        names.add("Reporte de Legislación y Regulación");
        details.add("Analiza las leyes y regulaciones relevantes para una industria o sector específico. Este reporte ayuda a las organizaciones a adaptarse a los cambios normativos y a garantizar su cumplimiento.");

        names.add("Reporte de Derecho Comparado");
        details.add("Estudia y compara diferentes sistemas legales de diversos países. Este informe es útil para identificar mejores prácticas y entender cómo se abordan problemas legales en distintas jurisdicciones.");

        names.add("Reporte de Investigación Legal");
        details.add("Documenta el análisis y la investigación de temas legales específicos. Este reporte es esencial para fundamentar argumentos y estrategias en casos legales.");

        names.add("Informe de Riesgo Legal");
        details.add("Identifica y evalúa los riesgos legales potenciales que enfrenta una organización. Incluye recomendaciones para mitigar estos riesgos y mejorar la gestión legal.");

        names.add("Reporte de Peritaje o Informe Pericial");
        details.add("Presenta la opinión de un experto sobre un aspecto técnico o legal de un caso. Este informe es fundamental en litigios donde se requiere conocimiento especializado para tomar decisiones.");

        names.add("Informe de Derechos Humanos");
        details.add("Analiza el cumplimiento de los derechos humanos en las operaciones de una organización. Este informe es crucial para asegurar que se respeten y promuevan los derechos fundamentales.");

        names.add("Reporte de Due Diligence Legal");
        details.add("Documenta el proceso de investigación y evaluación de riesgos legales en una transacción o adquisición. Este reporte es vital para tomar decisiones informadas y minimizar riesgos.");

        names.add("Reporte de Litigios Activos");
        details.add("Compila información sobre los litigios en curso que enfrenta una organización. Incluye detalles sobre el estado de los casos y las estrategias legales a seguir.");

        names.add("Informe de Propiedad Intelectual");
        details.add("Evalúa la protección y gestión de los derechos de propiedad intelectual de una organización. Este informe es clave para asegurar que se respeten las invenciones, marcas y derechos de autor.");

        names.add("Reporte de Evaluación de Contratos");
        details.add("Analiza los contratos vigentes de una organización para garantizar su cumplimiento y eficacia. Este reporte identifica riesgos contractuales y propone mejoras en la redacción de contratos.");

        adapter = new ReportAdapter(this, names, details);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.toggleDetail(position); // Alterna la visibilidad del detalle
            }
        });
    }
}
