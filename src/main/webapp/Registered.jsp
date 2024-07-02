<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet">
<link href="CSS/registration.css" rel="stylesheet">

<style>
    body {
        background-image: url('Imgs/alumni1.jpg');
        background-size: cover; 
        background-position: center;
    }

    .registration-form {
       backdrop-filter:blur(25px);
        border-radius: 20px;
        padding: 30px;
    }

    .registration-form h2 {
        color: #EB6ECF;
        margin-bottom: 30px;
    }

    .registration-form .btn-primary {
        background-color: #EB6ECF;
        border: none;
        transition: background-color 0.3s ease-in-out;
    }

    .registration-form .btn-primary:hover {
        background-color: #d04c9c;
    }

    .registration-form input[type="text"],
    .registration-form input[type="email"],
    .registration-form input[type="password"] {
        background-color: rgba(255, 255, 255, 0.7);
        border: none;
        border-radius: 10px;
        color: #333;
        margin-bottom: 20px;
        padding: 15px;
        transition: box-shadow 0.3s ease-in-out;
    }

    .registration-form input[type="text"]:focus,
    .registration-form input[type="email"]:focus,
    .registration-form input[type="password"]:focus {
        box-shadow: 0 0 10px rgba(235, 110, 207, 0.5);
    }
</style>
</head>
<body>

<div class="container-fluid">
    <div class="row justify-content-center align-items-center" style="height: 100vh;">
        <div class="col-lg-6">
            <div class="registration-form shadow-lg p-5">
                <h2 class="text-center">Registration Form</h2>
                <form name='frm' action="adminregistration" method="post">
                    <div class="mb-3">
                        <input type="text" name="name" class="form-control" placeholder="College Name" required>
                    </div>
                    <div class="mb-3">
                        <input type="email" name="email" class="form-control" placeholder="College Email" required>
                    </div>
                    <div class="mb-3">
                        <input type="text" name="contact" class="form-control" placeholder="College Contact" required>
                    </div>
                    <div class="mb-3">
                        <input type="text" name="address" class="form-control" placeholder="College Address" required>
                    </div>
                    <div class="mb-3">
                        <input type="password" name="pass" class="form-control" placeholder="Password" required>
                    </div>
                    <div class="mb-3">
                        <input type="password" name="pass1" class="form-control" placeholder="Confirm Password" required>
                    </div>
                    <div class="text-center">
                        <button type="submit" value="Register" class="btn btn-primary btn-block">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</body>
</html>
