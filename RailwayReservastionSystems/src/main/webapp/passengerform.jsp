
<html>
</head>
<body>
  <h3>Passenger Registration</h3>


  <form name="passengerForm" action="passenger/register" method="post" >
    <div>
      <label for="name">Name:</label>
      <input id="name" name="name" type="text" />
    </div> <br>

    <div>
          <label for="email">Email:</label>
          <input id="email" name="email" type="email" />
        </div><br>

        <div>
          <label for="mobile">Mobile:</label>
          <input id="mobile" name="mobile" type="text" />
        </div><br>

        <div>
          <label for="categorySelect">Category:</label>
          <select id="categorySelect" name="category">
            <option value="General">General</option>
            <option value="Senior Citizen">Senior Citizen</option>
            <option value="Physically Handicapped">Physically Handicapped</option>
          </select>
        </div><br>

        <div id="seniorDiv" class="form-row" style="display:none;">
          <label for="seniorCitizenId">Senior Citizen Id:</label>
          <input id="seniorCitizenId" name="seniorCitizenId" type="text" maxlength="100" />
        </div><br>
        <div id="physDiv" class="form-row">
              <label for="physHandicappedProof">Physical Handicapped Proof:</label>
              <input id="physHandicappedProof" name="physHandicappedProof" type="text" maxlength="200" />
            </div><br>

            <div class="form-row">
              <label></label>
              <button type="submit">Submit</button>
            </div>
          </form>
        </body>