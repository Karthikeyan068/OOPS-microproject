async function calculateCutoff() {
    // Get input values
    const maths = parseFloat(document.getElementById("maths").value) || 0;
    const physics = parseFloat(document.getElementById("physics").value) || 0;
    const chemistry = parseFloat(document.getElementById("chemistry").value) || 0;

    // Validate input values
    if (maths < 0 || maths > 100 || physics < 0 || physics > 100 || chemistry < 0 || chemistry > 100) {
        document.getElementById("result").innerText = "Please enter valid marks between 0 and 100.";
        return;
    }

    // Prepare data for API
    const data = {
        maths: maths,
        physics: physics,
        chemistry: chemistry
    };

    try {
        // Send POST request to the API
        const response = await fetch("http://localhost:8080/api/cutoff/calculate", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        });

        // Handle the API response
        if (response.ok) {
            const result = await response.json();
            document.getElementById("result").innerText =
                `Your cutoff is: ${result.cutoff.toFixed(2)} / 200 (Saved to database)`;
        } else {
            document.getElementById("result").innerText =
                "Error: Unable to calculate cutoff. Please try again.";
        }
    } catch (error) {
        console.error("Error connecting to the API:", error);
        document.getElementById("result").innerText =
            "Error: Could not connect to the server. Please try again later.";
    }
}
