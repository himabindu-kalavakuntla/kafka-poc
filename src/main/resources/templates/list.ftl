<div class="generic-container" width="100%" height="100%">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Add Employee </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.user.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="firstName">First Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.firstName" id="firstName" class="username
                                form-control
                                input-sm" placeholder="Enter your first name" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="lastName">Last Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.lastName" id="lastName" class="form-control
                                input-sm" placeholder="Enter your last name." required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="phoneNumber">Phone Number</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.phoneNumber" id="phoneNumber" class="form-control input-sm"
                                 placeholder="Enter your phone number" required ng-pattern="ctrl.onlyNumbers"/>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="emailAddress">Email</label>
                            <div class="col-md-7">
                                <input type="email" ng-model="ctrl.user.emailAddress" id="emailAddress" class="form-control
                                input-sm"
                                 placeholder="Enter your Email" required/>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="signedOnHarrassementPolicy">Signup for
                            Harrassement Policy</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.signedOnHarrassementPolicy" id="signedOnHarrassementPolicy" class="form-control input-sm"
                                 placeholder="Enter Yes or No" required/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="signedOnEmployeeAgreement">Signup for
                            Employee Agreement</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.signedOnEmployeeAgreement" id="signedOnEmployeeAgreement" class="form-control input-sm"
                                 placeholder="Enter Yes or No" required/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="enrolledForMedicalInsurance">Enroll For Medical Insurance</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.enrolledForMedicalInsurance" id="enrolledForMedicalInsurance" class="form-control input-sm"
                                 placeholder="Enter Yes or No." required/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="enrolledForBenefits">Enroll For Benefits</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.enrolledForBenefits" id="enrolledForBenefits" class="form-control input-sm"
                                 placeholder="Enter Yes or No." required/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Employees </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Ph No</th>
                        <th>Email</th>
                        <th>Signed On Harrassement Policy</th>
                        <th>Signed On Employee Agreement</th>
                        <th>Enrolled For Medical Insurance</th>
                        <th>Enrolled For Benefits</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="e in ctrl.getAllUsers()">
                        <td>{{e.id}}</td>
                        <td>{{e.firstName}}</td>
                        <td>{{e.lastName}}</td>
                        <td>{{e.phoneNumber}}</td>
                        <td>{{e.emailAddress}}</td>
                        <td>{{e.signedOnHarrassementPolicy}}</td>
                        <td>{{e.signedOnEmployeeAgreement}}</td>
                        <td>{{e.enrolledForMedicalInsurance}}</td>
                        <td>{{e.enrolledForBenefits}}</td>
                        <td><button type="button" ng-click="ctrl.editUser(e.id)" class="btn btn-success
                        custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeUser(e.id)" class="btn btn-danger
                        custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>