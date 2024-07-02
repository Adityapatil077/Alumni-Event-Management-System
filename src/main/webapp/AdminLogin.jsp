<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet">
<script src="JS/valid.js"></script>
<link href="CSS/adminstyle.css" rel="stylesheet">
</head>
<body style="background-image: url('Imgs/alumni1.jpg'); background-size: cover; background-position: center; color : white;">

<div class="container-fluid">
    <div class="row justify-content-center align-items-center" style="height: 100vh;">
        <div class="col-md-4" style=" backdrop-filter:blur(25px);">
            <form name='frm' action="login" method="post" class="p-4  rounded shadow">
                <h1 class="text-center mb-4">Login</h1>
                <!-- Email input -->
                <div class="form-group mb-4">
                    <label class="form-label" for="form2Example1">Email address</label>
                    <input type="email" name='email' id="form2Example1" value='' class="form-control" placeholder="Enter Email" onkeyup="EmailValidation(this.value)" required/>
                </div>

                <!-- Password input -->
                <div class="form-group mb-4">
                    <label class="form-label" for="form2Example2">Password</label>
                    <input type="password" name='password' id="form2Example2" value='' class="form-control" onkeyup="PasswordValidation(this.value)" placeholder="Enter Password" required/>
                </div>

<!--                 Checkbox and forgot password link -->
<!--                 <div class="row mb-4"> -->
<!--                     <div class="col-6"> -->
<!--                         <div class="form-check"> -->
<!--                             <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked /> -->
<!--                             <label class="form-check-label" for="form2Example31"> Remember me </label> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="col-6 text-end"> -->
<!--                         <a href="#!" style="color : #EB6ECF">Forgot password?</a> -->
<!--                     </div> -->
<!--                 </div> -->

                <!-- Submit button -->
                <button type="submit" value='LoginIn' class="btn btn-primary btn-block mb-4">Sign in</button>

                <!-- Register buttons -->
                <div class="text-center">
                    <p>Not a member? <a href="Registered.jsp" style="color : #EB6ECF">Register</a></p>
                    <p>or sign up with:</p>
                    <button type="button" class="btn btn-link btn-floating mx-1">
                        <ion-icon name="logo-facebook" class="animate__animated animate__bounce"></ion-icon>
                    </button>

                    <button type="button" class="btn btn-link btn-floating mx-1">
                        <ion-icon name="logo-google" class="animate__animated animate__bounce"></ion-icon>
                    </button>

                    <button type="button" class="btn btn-link btn-floating mx-1">
                        <ion-icon name="logo-twitter" class="animate__animated animate__bounce"></ion-icon>
                    </button>

                    <button type="button" class="btn btn-link btn-floating mx-1">
                        <ion-icon name="logo-github" class="animate__animated animate__bounce"></ion-icon>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">

</script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<script src="JS/valid.js"></script>
</body>
</html>
