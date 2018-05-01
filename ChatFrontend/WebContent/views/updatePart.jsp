 <div class="container-fluid" ng-controller="UserController"> 
                 <li  ng-hide="currentUser==undefined" ng-show="currentUser.role=='ROLE_USER'">
                 <a href="#editTheForm" ng-click="editUser(currentUser.userName)" data-toggle="modal"> View Profile</a></li>
   
 <div class="modal fade" id="editTheForm" tabindex="-1" data-keyboard="false" data-backdrop="static" role="dialog">  
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit User</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<form class="col-md-12 center-block" id="blogForm" method="POST">
					 
					
				 <div class="form-group">
					<label for="firstName">
						First Name
					</label>
					<input type="text" class="form-control" id="firstName"  ng-model="user.firstName" />
				</div>
				<div class="form-group">
					<label for="lastName">
						Last Name
					</label>
					<input type="text" class="form-control" id="lastName"  ng-model="user.lastName" />
				</div>
				<div class="form-group">
				<label for="email">
						Email
					</label>
					<input type="text" class="form-control" id="email"  ng-model="user.email" />
				</div>
				
				<div class="form-group">
					 
					<label for="gender">
						Gender
					</label>
					<input type="text" class="form-control" id="gender"  ng-model="user.gender" />
				</div>
				
				<div class="form-group">
					 
					<label for="Age">
						Age
					</label>
					<input type="text" class="form-control" id="age"  ng-model="user.age" />
				</div>
				
				
				<div class="form-group">
				<label for="contactNo">
						Contact Number
					</label>
					<input type="text" class="form-control" id="contactNo"  ng-model="user.contactNo" />
				</div>		
				
				
				
				<div class="form-group">
				
				<input type="submit" value="Register" class="btn btn-primary" ng-click="Register()">
					</div>
			</form>
				</div>
			</div>
		</div>		
	</div>
</div>
</div>
                