function loadVitals(){

    fetch("http://localhost:8080/api/vitals")
        .then(response => response.json())
        .then(data => {

            let tbody =
                document.querySelector("#vitalsTable tbody");

            tbody.innerHTML="";

            let critical=0;
            let totalHR=0;
            let totalSpo2=0;

            data.forEach(v => {

                totalHR += v.heartRate;
                totalSpo2 += v.spo2;

                if(v.status==="CRITICAL_ALERT"){
                    critical++;
                }

                tbody.innerHTML += `
        <tr class="${
                    v.status==="CRITICAL_ALERT"
                        ? "critical-row"
                        : "normal-row"
                }">

            <td>${v.id}</td>
            <td>${v.patientId}</td>
            <td>${v.heartRate}</td>
            <td>${v.spo2}</td>
            <td>${v.temperature}</td>

            <td>
                <span class="${
                    v.status==="CRITICAL_ALERT"
                        ? "badge-critical"
                        : "badge-normal"
                }">
                ${v.status}
                </span>
            </td>

        </tr>`;
            });

            document.getElementById("totalCount")
                .innerText=data.length;

            document.getElementById("criticalCount")
                .innerText=critical;

            document.getElementById("avgHeartRate")
                .innerText=Math.round(totalHR/data.length);

            document.getElementById("avgSpo2")
                .innerText=Math.round(totalSpo2/data.length)+"%";
        });
}

loadVitals();

setInterval(loadVitals,5000);