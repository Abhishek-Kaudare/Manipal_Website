@extends('admin_layout.master')

@foreach ($data as $item)
    @if($item->auth==0)

        @section('sidebarOptions')
    <nav class="sidebar-nav">
      <ul id="sidebarnav" class="p-t-30">
        
    <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark" href="{{ url('DoctorCompleteRegistration') }}"
            aria-expanded="false"><i class="mdi mdi-receipt"></i><span class="hide-menu">Complete Registration</span></a>
        </li>       
      </ul>
    </nav>
@endsection
    @endif

    @if($item->auth==2)
     @section('content')
    WAIT FOR AUTHORIZATION
@endsection
    @endif

    @if($item->auth==1)
     @section('content')
    @section('sidebarOptions')
    <nav class="sidebar-nav">
      <ul id="sidebarnav" class="p-t-30">    
          
          <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark" href="{{ url('medicalspeciality') }}"
            aria-expanded="false"><i class="mdi mdi-receipt"></i><span class="hide-menu">MEDICAL SPECIALITY</span></a>
        </li>
        
        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark" href="{{ url('language') }}"
            aria-expanded="false"><i class="mdi mdi-receipt"></i><span class="hide-menu">ADD LANGUAGE</span></a>
        </li>

        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark" href="{{ url('awards') }}"
            aria-expanded="false"><i class="mdi mdi-receipt"></i><span class="hide-menu">AWARD AND ACHIEVEMENT</span></a>
        </li>
        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark" href="{{ url('research') }}"
            aria-expanded="false"><i class="mdi mdi-receipt"></i><span class="hide-menu">RESEARCH AND PUBLICATION</span></a>
        </li>
        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark" href="{{ url('summary') }}"
            aria-expanded="false"><i class="mdi mdi-receipt"></i><span class="hide-menu">SUMMARY</span></a>
        </li>
        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark" href="{{ url('hosrequst') }}"
            aria-expanded="false"><i class="mdi mdi-receipt"></i><span class="hide-menu">HOSPITAL/CLINIC REQUEST</span></a>
        </li>
        
        
      </ul>
    </nav>
@endsection
@endsection
    @endif



@endforeach



{{-- {{ print_r($data[0][0]) }} --}}
{{-- @section('sidebarOptions')
    <nav class="sidebar-nav">
      <ul id="sidebarnav" class="p-t-30">
        
        <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)"
            aria-expanded="false"><i class="mdi mdi-receipt"></i><span class="hide-menu">Forms </span></a>
          <ul aria-expanded="false" class="collapse  first-level">
            <li class="sidebar-item"><a href="form-basic.html" class="sidebar-link"><i
                  class="mdi mdi-note-outline"></i><span class="hide-menu"> Form Basic </span></a></li>
            <li class="sidebar-item"><a href="form-wizard.html" class="sidebar-link"><i
                  class="mdi mdi-note-plus"></i><span class="hide-menu"> Form Wizard </span></a></li>
          </ul>
        </li>
        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link" href="pages-buttons.html"
            aria-expanded="false"><i class="mdi mdi-relative-scale"></i><span class="hide-menu">Buttons</span></a></li>
        <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)"
            aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Icons </span></a>
          <ul aria-expanded="false" class="collapse  first-level">
            <li class="sidebar-item"><a href="icon-material.html" class="sidebar-link"><i
                  class="mdi mdi-emoticon"></i><span class="hide-menu"> Material Icons </span></a></li>
            <li class="sidebar-item"><a href="icon-fontawesome.html" class="sidebar-link"><i
                  class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Font Awesome Icons </span></a></li>
          </ul>
        </li>
       
        
        
      </ul>
    </nav>
@endsection --}}