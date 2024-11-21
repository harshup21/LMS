document.addEventListener("DOMContentLoaded", () => {
    // Dynamic content mapping for each section
    const sections = {
        students: {
            title: "Student Management",
            content: `
                <p>Here you can view, add and remove students.</p>
                <ul>
                    <li><a href="/students/list">View All Students</a></li>
                    <li><a href="/students/add">Add New Student</a></li>
                </ul>
            `,
        },
        courses: {
            title: "Course Management",
            content: `
                <p>You can manage, update and remove courses.</p>
                <ul>
                    <li><a href="/courses/list">View All Courses</a></li>
                    <li><a href="/courses/add">Add New Course</a></li>
                </ul>
            `,
        },
        assessments: {
            title: "Assessment Management",
            content: `
                <p>Manage assessments and quizzes for students.</p>
                <ul>
                    <li><a href="/assessments/list">View All Assessments</a></li>
                    <li><a href="/assessments/add">Create New Assessment</a></li>
                </ul>
            `,
        },
        results: {
            title: "Results Management",
            content: `
                <p>Manage and view student performance and results.</p>
                <ul>
                    <li><a href="/results/list">View All Results</a></li>
                    <li><a href="/results/upload">Upload New Results</a></li>
                </ul>
            `,
        },
    };

    // Function to update dynamic content based on section selection
    const openSection = (sectionKey) => {
        const dynamicContent = document.getElementById("dynamic-content");

        // Check if the section exists and update content, else show an error
        if (sections[sectionKey]) {
            const section = sections[sectionKey];
            dynamicContent.innerHTML = `
                <h3 class="text-center">${section.title}</h3>
                <div class="text-center">${section.content}</div>
            `;
        } else {
            dynamicContent.innerHTML = `
                <h3 class="text-center text-danger">Section Not Found</h3>
                <p class="text-center">The selected section does not exist. Please try again.</p>
            `;
        }
    };

    // Add hover effects for interactivity
    const addCardHoverEffect = (card) => {
        card.addEventListener("mouseenter", () => {
            card.style.cursor = "pointer"; // Add a pointer cursor for better UX
            card.style.transform = "scale(1.05)"; // Slightly scale up for hover effect
            card.style.transition = "transform 0.3s ease"; // Smooth transition
        });

        card.addEventListener("mouseleave", () => {
            card.style.transform = "scale(1)"; // Reset the scale on mouse leave
        });
    };

    // Attach click event listeners to the dashboard cards
    document.querySelectorAll(".dashboard-card").forEach((card) => {
        addCardHoverEffect(card); // Apply hover effects

        card.addEventListener("click", () => {
            const sectionId = card.id.replace("-card", ""); // Extract section ID (remove "-card")
            openSection(sectionId); // Update dynamic content
        });
    });

    // Optionally, set default section to show when page loads (e.g., "students" section)
    openSection("students");

    // Highlight table rows on hover
    const rows = document.querySelectorAll("table tbody tr");
    rows.forEach(row => {
        row.addEventListener("mouseover", () => {
            row.style.backgroundColor = "#f0f5ff";
        });

        row.addEventListener("mouseout", () => {
            row.style.backgroundColor = "white";
        });
    });

    // Smooth scroll to form
    const backToTopButtons = document.querySelectorAll(".btn-secondary");
    backToTopButtons.forEach(button => {
        button.addEventListener("click", event => {
            event.preventDefault();
            document.querySelector("header").scrollIntoView({
                behavior: "smooth",
                block: "start"
            });
        });
    });

    // Show confirmation before delete
    const deleteButtons = document.querySelectorAll(".btn-danger");
    deleteButtons.forEach(button => {
        button.addEventListener("click", event => {
            const confirmed = confirm("Are you sure you want to delete this assessment?");
            if (!confirmed) {
                event.preventDefault();
            }
        });
    });
});
