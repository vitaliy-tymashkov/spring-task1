<!DOCTYPE html>
<html>
    <head>
        <title>Upload Users to Phone Book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>

        <div align="center">
        <h2>Uploaded Results page</h2>
        <p>${quantity} files uploaded successfully

        <table border=1>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Phone Company</th>
            </tr>

            <#list phones as record>
                <tr>
                    <td>${record.id}</td>
                    <td>${record.name}</td>
                    <td>${record.phoneNumber}</td>
                    <td>${record.phoneCompany}</td>
                </tr>
            </#list>
        </table>
        </div>

        <div class="footer" align="center">
                <p><a href="/">Home Page</a>
                <p>
                <p><a href="phonebook">Show Phone Book</a>
                <p>
                                <p><a href="phonebookPDF">Create Phone Book in PDF</a>
                                <p>
                <p><a href="uploadStatic.html">Upload Phone Book</a>
        </div>
    </body>

</html>
