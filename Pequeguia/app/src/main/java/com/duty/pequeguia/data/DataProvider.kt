package com.duty.pequeguia.data

import com.duty.pequeguia.R

object DataProvider {
    val consejo = Consejo(
        id = 1,
        tittle = "Cómo aliviar los colicos de tu bebé",
        subtittle = "¿Qué hacer para aliviar a mi bebé si sufre un cólico?",
        content =
                "Aliviar los cólicos del lactante puede parecer una tarea complicada, especialmente si este es el primer bebé que tienes. No obstante, comprobarás que poco a poco te irás acostumbrando a la situación y que resolverás los problemas con mucha más soltura.\n\n Pero, ¿qué hacer para aliviar al bebé si sufre un cólico?\n" +
                "- \b Masajes en el vientre de tu bebé: masajear en el sentido de las agujas del reloj el vientre de tu bebé puede ayudarle a aliviar las molestias que provocan los cólicos del lactante. Eso sí, observa si lo que estás haciendo le incomoda o no, ya que hay bebés que no toleran este tipo de masajes.\n\n" +
                "- Baños de agua tibia: los baños de agua tibia ayudarán a reducir ese malestar producido por los cólicos del lactante. Si responde bien, un par de baños al día sería lo ideal. También se recomienda poner una bolsa de agua tibia en la tripa del bebé para aliviar los cólicos.\n\n" +
                "- Mécelo suavemente en tus brazos: en las crisis de llantos, lo mejor es colocar al bebé en el hombro y moverlo suavemente. El movimiento puede ayudarle a sentirse mejor, por lo que, además, se recomienda que en las tomas se le cambie de posición para evitar la acumulación de aire.\n\n" +
                "- Colóquese al bebé en el regazo, estirado boca abajo, y frótele suavemente la espalda.\n\n" +
                "- Pon un poco de música. La música que escuchabas en tu embarazo puede ayudarlo a calmarlo. También prueba cantar o hacer un ruido rítmico que ayude al bebé a distraerse y calmarse.\n\n" +
                "- Sigue una buena dieta: si das el pecho, lo recomendable es que sigas una buena dieta. Ten en cuenta que todo lo que tú tomes lo tomará el bebé.\n",
        image = R.drawable.c1
    )

    val consejo_list = listOf(
        consejo,
        Consejo(
            id = 2,
            tittle = "Cuánto debe comer un bebé de 0 - 6 meses",
            subtittle = "",
            content = "La cantidad de alimento que debe consumir un bebé varía según su edad y etapa de desarrollo. Durante los primeros 12 meses de vida, los bebés pasan por distintas fases de alimentación, comenzando exclusivamente con leche materna o fórmula y luego integrando alimentos sólidos.\n" +
                    "Aquí tienes una guía general de la alimentación de un bebé de 0 a 12 meses:\n" +
                    "0 a 4 meses\n" +
                    "Alimentación exclusiva con leche materna o fórmula infantil.\n" +
                    "Frecuencia: Cada 2-3 horas, es decir, entre 8 y 12 tomas diarias.\n" +
                    "Cantidad:\n" +
                    "Recién nacido: 30-60 ml (1-2 oz) por toma si es alimentado con fórmula.\n" +
                    "A los 2 meses: 60-120 ml (2-4 oz) por toma.\n" +
                    "A los 4 meses: 120-180 ml (4-6 oz) por toma.\n" +
                    "Los bebés suelen regular su ingesta, y su demanda puede variar. Algunos bebés amamantados pueden comer con mayor frecuencia.\n" +
                    "4 a 6 meses\n" +
                    "Alimentación principal: leche materna o fórmula.\n" +
                    "Cantidad de fórmula: Aproximadamente 120-180 ml (4-6 oz) por toma, cada 3-4 horas.\n" +
                    "Introducción de alimentos sólidos (opcional): Generalmente a los 6 meses, aunque algunos bebés están listos un poco antes.\n" +
                    "Al iniciar sólidos, se suele empezar con purés de frutas, verduras o cereales para bebés, como arroz o avena.\n" +
                    "Cantidad: Comenzar con 1 o 2 cucharadas una vez al día, aumentando gradualmente.\n",
            image = R.drawable.c2
        ),
        Consejo(
            id = 3,
            tittle = "Cuántas horas debe dormir un bebé de 2 meses",
            subtittle = "Detalles sobre el sueño de un bebé de 2 meses:",
            content = "- Horas totales de sueño:\n" +
                    "Un bebé de 2 meses generalmente necesita entre 14 y 17 horas de sueño al día. " +
                    "El sueño se distribuye entre la noche y varias siestas a lo largo del día, con un patrón aún en formación.\n\n" +
                    "- Sueño nocturno:\n" +
                    "\t* Duración del sueño nocturno: Entre 6 y 8 horas en total, pero no de forma continua. A los 2 meses, es común que el bebé se despierte cada 3 a 4 horas durante la noche para alimentarse, debido a que sus estómagos aún son pequeños y necesitan comer con frecuencia.\n" +
                    "\t* Despertares nocturnos: Aunque algunos bebés pueden empezar a alargar un poco más los tramos de sueño, no es habitual que duerman toda la noche sin despertarse. La mayoría se despierta para comer o cambiarse el pañal.\n" +
                    "\t* Evolución: A medida que se acercan a los 3 meses, algunos bebés pueden comenzar a tener una mayor consolidación del sueño nocturno y extender los periodos de sueño ininterrumpido.\n\n" +
                    "- Siestas diurnas:\n" +
                    "\t* Duración de las siestas: A los 2 meses, un bebé toma entre 3 y 5 siestas al día, que pueden sumar entre 6 y 9 horas en total.\n" +
                    "\t* Frecuencia: Estas siestas pueden ser muy variables, algunas duran entre 30 minutos y otras hasta 2 horas. Las siestas diurnas suelen ocurrir cada 1-2 horas de estar despiertos.\n" +
                    "\t* Señales de sueño: Es importante observar las señales de que el bebé está cansado, como frotarse los ojos, bostezar, estar irritable o no prestar atención a estímulos. Idealmente, debes acostar al bebé cuando comience a mostrar signos de cansancio para que se duerma sin estar sobreestimulado.",
            image = R.drawable.c3
        ),
        Consejo(
            id = 4,
            tittle = "Actividades para el desarrollo psicomotriz de tu bebé",
            subtittle = "",
            content = "El desarrollo psicomotriz de los bebés implica la adquisición de habilidades motoras, tanto gruesas como finas, así como la coordinación entre movimientos y la percepción del entorno. Estas actividades son fundamentales para fortalecer los músculos, mejorar el equilibrio y promover un crecimiento saludable en los primeros años de vida.\n" +
                    "Aquí tienes una lista de actividades recomendadas para promover el desarrollo psicomotriz de tu bebé, clasificadas según las diferentes etapas de su desarrollo:\n" +
                    "0 a 3 meses:\n" +
                    "Durante esta etapa, los bebés están desarrollando el control de su cabeza y comenzando a descubrir su cuerpo. Las actividades deben ser sencillas, enfocadas en estimular sus sentidos y fomentar movimientos básicos.\n" +
                    "Tummy Time (tiempo boca abajo):\n" +
                    "Coloca al bebé boca abajo sobre una manta suave o en tu pecho durante cortos periodos de tiempo (inicialmente 1-2 minutos, aumentando gradualmente).\n" +
                    "Beneficios: Fortalece los músculos del cuello, los brazos y la espalda, y ayuda a desarrollar el control de la cabeza.\n" +
                    "Reflejo de prensión:\n" +
                    "Ofrece juguetes pequeños y suaves para que el bebé trate de agarrarlos con las manos. Puede ser un sonajero o una pelotita blanda.\n" +
                    "Beneficios: Estimula la coordinación ojo-mano y mejora el agarre.\n" +
                    "Estimulación auditiva y visual:\n" +
                    "Usa juguetes sonoros o móviles con colores brillantes. Muévelos lentamente para que el bebé los siga con la vista.\n" +
                    "Beneficios: Estimula la visión y la audición, desarrollando la capacidad de seguimiento visual.",
            image = R.drawable.c4
        )
    )
}